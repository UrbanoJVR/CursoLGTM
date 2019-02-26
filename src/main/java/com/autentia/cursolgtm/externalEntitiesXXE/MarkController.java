package com.autentia.cursolgtm.externalEntitiesXXE;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringBufferInputStream;

@RestController
@RequestMapping("/mark")
public class MarkController {

    private Mark mark;

    @RequestMapping(value = "/student-last-name" , method = RequestMethod.GET, produces = MediaType.TEXT_XML_VALUE)
    public String getMarks() {
        return mark.getStudentLastName();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {"application/xml", "text/xml"})
    @ResponseStatus(value = HttpStatus.OK)
    public void addMark(@RequestBody String xmlMark) {
        try {
            this.mark = deserializeXMLMark(xmlMark);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private Mark deserializeXMLMark(String xmlMark) throws SAXException, ParserConfigurationException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new StringBufferInputStream(xmlMark));
        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("mark");

        return getMark(nodeList.item(0));
    }

    private static Mark getMark(Node node) {
        Mark mark = new Mark();

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            mark.setStudentName(getTagValue("studentName", element));
            mark.setStudentLastName(getTagValue("studentLastName", element));
            mark.setMark(Float.parseFloat(getTagValue("mark", element)));
        }

        return mark;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

}
