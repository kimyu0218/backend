package com.example.backend.dao;

import static com.example.backend.dao.RouteSqls.*;

import java.util.*;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.example.backend.dto.Route;

@Repository
public class RouteDao {
    private NamedParameterJdbcOperations jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<Route> rowMapper = BeanPropertyRowMapper.newInstance(Route.class);

    public RouteDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("route");
    }

    // 1. 응급 차량 서비스
    public int deleteRoute(int emergency_car_id, Date time) { // 특정 레코드 삭제
        Map<String, Object> params = new HashMap<>();
        params.put("emergency_car_id", emergency_car_id);
        params.put("time", time);
        return jdbc.update(DELETE_BY_TIME, params);
    }

    public int insertRoute(Route route) { // 레코드 삽입
        int insertCount = 0;
        SqlParameterSource params = new BeanPropertySqlParameterSource(route);
        insertAction.execute(params);
        return ++insertCount;
    }

    // 2. 일반 차량 서비스
    public int isEmpty(){ // 데이터베이스 레코드 개수 카운트
        return jdbc.queryForObject(IS_DB_EMPTY, Collections.emptyMap(), Integer.class);
    }

    public List<Route> findClosestNode(Date time){
        Map<String, Date> params = Collections.singletonMap("time", time);
        return jdbc.query(SORT_BY_TIME, params, rowMapper);
    }

}
