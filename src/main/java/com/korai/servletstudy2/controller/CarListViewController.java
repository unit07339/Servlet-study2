package com.korai.servletstudy2.controller;


import com.korai.servletstudy2.service.CarService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/car/list")
public class CarListViewController extends HttpServlet {
    private CarService carService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        carService = CarService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("carlist", carService.getCarAll());
        req.getRequestDispatcher("/WEB-INF/views/car-list.jsp").forward(req, resp);
    }
}

