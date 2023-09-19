package ua.kpi.kpiecologyback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.kpi.kpiecologyback.domain.Company;
import ua.kpi.kpiecologyback.domain.Pollutant;
import ua.kpi.kpiecologyback.domain.Pollution;
import ua.kpi.kpiecologyback.service.DataService;

import java.io.IOException;

import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController {
    private final DataService dataService;
    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping("/upload/csv/company")
    public void uploadCompany(@RequestParam("file") MultipartFile file) throws IOException {
        dataService.uploadCompany(new String(file.getBytes(), "WINDOWS-1251"));
    }

    @PostMapping("/upload/csv/pollutant")
    public void uploadPollutant(@RequestParam("file") MultipartFile file) throws IOException {
        dataService.uploadPollutant(new String(file.getBytes(), "WINDOWS-1251"));
    }

    @PostMapping("/upload/csv/pollution")
    public void uploadPollution(@RequestParam("file") MultipartFile file) throws IOException {
        dataService.uploadPollution(new String(file.getBytes(), "WINDOWS-1251"));
    }

    @PostMapping("/upload/company")
    public void uploadCompany(@RequestBody Company company) {
        dataService.uploadCompany(company);
    }

    @PostMapping("/upload/pollutant")
    public void uploadPollutant(@RequestBody Pollutant pollutant) {
        dataService.uploadPollutant(pollutant);
    }

    @PostMapping("/upload/csv/pollution")
    public void uploadPollution(@RequestBody Pollution pollution) {
        dataService.uploadPollution(pollution);
    }

    @GetMapping("/get/company")
    public List<Company> getAllCompany () {
        return dataService.getAllCompany();
    }

    @GetMapping("/get/pollutant")
    public List<Pollutant> getAllPollutant () {
        return dataService.getAllPollutant();
    }

    @GetMapping("/get/pollution")
    public List<Pollution> getAllPollution () {
        return dataService.getAllPollution();
    }

    @PostMapping("/update/company")
    public void updateCompany (@RequestBody Company company) {
        dataService.updateCompany(company);
    }

    @PostMapping("/update/pollutant")
    public void updatePollutant (@RequestBody Pollutant pollutant) {
        dataService.updatePollutant(pollutant);
    }

    @PostMapping("/update/pollution")
    public void updatePollution (@RequestBody Pollution pollution) {
        dataService.updatePollution(pollution);
    }

    @PostMapping("/delete/company")
    public void deleteCompany (@RequestParam long id) {
        dataService.deleteCompany(id);
    }

    @PostMapping("/delete/pollutant")
    public void deletePollutant (@RequestParam long id) {
        dataService.deletePollutant(id);
    }

    @PostMapping("/delete/pollution")
    public void deletePollution (@RequestParam long id) {
        dataService.deletePollution(id);
    }
}
