package com.korai.servletstudy2.controller;

import com.korai.servletstudy2.model.Car;
import com.korai.servletstudy2.service.CarService;
import tools.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/api/cars")
public class CarApiController extends HttpServlet {
    private CarService carService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        carService = CarService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");   // 추가

        req.setCharacterEncoding("UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = objectMapper.readValue(req.getInputStream(), Car.class);

        carService.register(car);
        System.out.println(car);

        resp.setContentType("application/json");                                  // 추가
        resp.setCharacterEncoding("UTF-8");                                       // 추가
        resp.getWriter().println(objectMapper.writeValueAsString(Map.of(          // 추가
                "message", "자동차 등록 성공"
        )));
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) {
        setCors(resp);
        resp.setStatus(200);
    }

    private void setCors(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        List<Car> cars = carService.getCarAll();
        ObjectMapper objectMapper = new ObjectMapper();
        resp.getWriter().println(objectMapper.writeValueAsString(cars));
    }
}
