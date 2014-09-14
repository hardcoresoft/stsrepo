package com.tnc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/upload")
public class DocumentController {
     
//    @Autowired
//    private DocumentDao documentDao;
//     
//    @RequestMapping("/index")
//    public String index(Map<String, Object> map) {
//        try {
//            map.put("document", new Document());
//            map.put("documentList", documentDao.list());
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
// 
//        return "/fileUpload/documents";
//    }
// 
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public String save(
//            @ModelAttribute("document") Document document,
//            @RequestParam("file") MultipartFile file) {
//         
//         
//        System.out.println("Name:" + document.getName());
//        System.out.println("Desc:" + document.getDescription());
//        System.out.println("File:" + file.getName());
//        System.out.println("ContentType:" + file.getContentType());
//         
//        try {
//            Blob blob = Hibernate.createBlob(file.getInputStream());
// 
//            document.setFilename(file.getOriginalFilename());
//            document.setContent(blob);
//            document.setContentType(file.getContentType());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//         
//        try {
//            documentDao.save(document);
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//         
//        return "redirect:/upload/index.html";
//    }
// 
//    @RequestMapping("/download/{documentId}")
//    public String download(@PathVariable("documentId")
//            Integer documentId, HttpServletResponse response) {
//         
//        Document doc = documentDao.get(documentId);
//        try {
//            response.setHeader("Content-Disposition", "inline;filename=\"" +doc.getFilename()+ "\"");
//            OutputStream out = response.getOutputStream();
//            response.setContentType(doc.getContentType());
//            IOUtils.copy(doc.getContent().getBinaryStream(), out);
//            out.flush();
//            out.close();
//         
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//         
//         
//        return null;
//    }
// 
//    @RequestMapping("/remove/{documentId}")
//    public String remove(@PathVariable("documentId")
//            Integer documentId) {
//         
//        documentDao.remove(documentId);
//         
//        return "redirect:/upload/index.html";
//    }
}