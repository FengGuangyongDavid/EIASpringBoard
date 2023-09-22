package com.spring.board.eia.service;

import com.spring.board.eia.entity.Organization;
import com.spring.board.eia.entity.Person;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

import static com.spring.board.eia.EIAConstant.*;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private PersonService personService;

    @Autowired
    private OrgService orgService;

    @Override
    public void doUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<FileItem> fileItems = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            for (FileItem fileItem : fileItems) {
                if (!fileItem.isFormField()) {
                    String name = new File(fileItem.getName()).getName();
                    fileItem.write(new File(UPLOAD_PATH + name));
                }
            }
            request.setAttribute("eia_message", "File uploaded successfully");
        } catch (Exception ex) {
            request.setAttribute("eia_message", "File upload failed due to " + ex);
        }
    }

    @Override
    public void doDownload(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        FileInputStream fileInputStream = new FileInputStream(DOWNLOAD_PATH + fileName);

        int i;
        while ((i = fileInputStream.read()) != -1) {
            out.write(i);
        }
        fileInputStream.close();
        out.close();
    }

    @Override
    public void generateFile() throws IOException {
        generatePersonFile();
        generateOrgFile();
    }

    private void generatePersonFile() throws IOException {
        List<Person> persons = personService.getAllPersons();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("person info");

        HSSFRow head = sheet.createRow((short)0);
        head.createCell(0).setCellValue("PersonId");
        head.createCell(1).setCellValue("CabinNo");
        head.createCell(2).setCellValue("FirstName");
        head.createCell(3).setCellValue("LastName");
        head.createCell(4).setCellValue("MHProvider");
        head.createCell(5).setCellValue("SUDProvider");
        head.createCell(6).setCellValue("CaseManagement");
        head.createCell(7).setCellValue("Need");
        head.createCell(8).setCellValue("PhoneNo");
        head.createCell(9).setCellValue("CabinStatus");
        head.createCell(10).setCellValue("StartDate");
        head.createCell(11).setCellValue("EndDate");
        head.createCell(12).setCellValue("Gender");
        head.createCell(13).setCellValue("Racial");
        head.createCell(14).setCellValue("Age");
        head.createCell(15).setCellValue("HistoryOfUse");
        head.createCell(16).setCellValue("ActiveUser");
        head.createCell(17).setCellValue("ActiveOtherSubstances");
        head.createCell(18).setCellValue("PreviousUser");
        head.createCell(19).setCellValue("OpiateTreatmentAtResidency");
        head.createCell(20).setCellValue("InTreatmentForOtherSubstances");
        head.createCell(21).setCellValue("InMentalHealthTreatment");
        head.createCell(22).setCellValue("NameOfProvider");
        head.createCell(23).setCellValue("DualDX");
        head.createCell(24).setCellValue("PermanentHouse");
        head.createCell(25).setCellValue("EntrustedAssertiveCommunity");
        head.createCell(26).setCellValue("Live");
        head.createCell(27).setCellValue("LongerTermSubstanceReturn");
        head.createCell(28).setCellValue("DecidedMove");
        head.createCell(29).setCellValue("ExitByRuleViolations");
        head.createCell(30).setCellValue("DocumentationAssistance");
        head.createCell(31).setCellValue("Achievements");

        int i = 1;
        for (Person person : persons) {
            HSSFRow row = sheet.createRow((short)i);
            row.createCell(0).setCellValue(person.getPersonId());
            row.createCell(1).setCellValue(person.getCabinNo());
            row.createCell(2).setCellValue(person.getFirstName());
            row.createCell(3).setCellValue(person.getLastName());
            row.createCell(4).setCellValue(person.getMHProvider());
            row.createCell(5).setCellValue(person.getSUDProvider());
            row.createCell(6).setCellValue(person.getCaseManagement());
            row.createCell(7).setCellValue(person.getNeed());
            row.createCell(8).setCellValue(person.getPhoneNo());
            row.createCell(9).setCellValue(person.getCabinStatus());
            row.createCell(10).setCellValue(person.getStartDate());
            row.createCell(11).setCellValue(person.getEndDate());
            row.createCell(12).setCellValue(person.getGender());
            row.createCell(13).setCellValue(person.getRacial());
            row.createCell(14).setCellValue(person.getAge());
            row.createCell(15).setCellValue(person.getHistoryOfUse());
            row.createCell(16).setCellValue(person.getActiveUser());
            row.createCell(17).setCellValue(person.getActiveOtherSubstances());
            row.createCell(18).setCellValue(person.getPreviousUser());
            row.createCell(19).setCellValue(person.getOpiateTreatmentAtResidency());
            row.createCell(20).setCellValue(person.getInTreatmentForOtherSubstances());
            row.createCell(21).setCellValue(person.getInMentalHealthTreatment());
            row.createCell(22).setCellValue(person.getNameOfProvider());
            row.createCell(23).setCellValue(person.getDualDX());
            row.createCell(24).setCellValue(person.getPermanentHouse());
            row.createCell(25).setCellValue(person.getEntrustedAssertiveCommunity());
            row.createCell(26).setCellValue(person.getLive());
            row.createCell(27).setCellValue(person.getLongerTermSubstanceReturn());
            row.createCell(28).setCellValue(person.getDecidedMove());
            row.createCell(29).setCellValue(person.getExitByRuleViolations());
            row.createCell(30).setCellValue(person.getDocumentationAssistance());
            row.createCell(31).setCellValue(person.getAchievements());
            i++;
        }

        FileOutputStream fileOut = new FileOutputStream(PERSON_DOWNLOAD_PATH);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        System.out.println("Person file has been generated!");
    }

    private void generateOrgFile() throws IOException {
        List<Organization> orgs = orgService.getAllOrgs();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("organization info");

        HSSFRow head = sheet.createRow((short)0);
        head.createCell(0).setCellValue("OrgId");
        head.createCell(1).setCellValue("orgName");
        head.createCell(2).setCellValue("Service");

        int i = 1;
        for (Organization org : orgs) {
            HSSFRow row = sheet.createRow((short)i);
            row.createCell(0).setCellValue(org.getOrgId());
            row.createCell(1).setCellValue(org.getOrgName());
            row.createCell(2).setCellValue(org.getService());
            i++;
        }

        FileOutputStream fileOut = new FileOutputStream(ORG_DOWNLOAD_PATH);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        System.out.println("Org file has been generated!");
    }
}
