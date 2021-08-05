package com.example.backend.dao;

import static com.example.backend.dao.RouteSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

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

    public RouteDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("route");
    }

    public int deleteRoute(int emergency_car_id, int node_id) { // 특정 레코드 삭제
        Map<String, Integer> params = new HashMap<>();
        params.put("emergency_car_id", emergency_car_id);
        params.put("node_id", node_id);
        return jdbc.update(DELETE_BY_ID, params);
    }

    public int insertRoute(Route route) { // 레코드 삽입
        int insertCount = 0;
        SqlParameterSource params = new BeanPropertySqlParameterSource(route);
        insertAction.execute(params);
        return ++insertCount;
    }
}
