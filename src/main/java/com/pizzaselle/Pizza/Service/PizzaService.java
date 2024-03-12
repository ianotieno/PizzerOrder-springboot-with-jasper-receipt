package com.pizzaselle.Pizza.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.pizzaselle.Pizza.Interface.PizzaInterface;
import com.pizzaselle.Pizza.model.Pizza;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
@Service
public class PizzaService {
    @Autowired
    private PizzaInterface pizzaInterface;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\developer\\Desktop\\report";
        List<Pizza> pizzas = pizzaInterface.findAll();
        File file = ResourceUtils.getFile("classpath:PizzaTest1.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(pizzas);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "ian");


        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\Receipt.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\Receipt.pdf");
        }
        return "Report Generated in path: " + path;
    }
}

