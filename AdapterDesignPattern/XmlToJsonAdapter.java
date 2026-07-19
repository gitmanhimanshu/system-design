public class XmlToJsonAdapter implements IJsonService {
    private XmlDataService xmlService;

    public XmlToJsonAdapter(XmlDataService xmlService) {
        this.xmlService = xmlService;
    }

    public String getJsonData() {
        String xml = xmlService.getXmlData();
        return convertXmlToJson(xml);
    }

    private String convertXmlToJson(String xml) {
        String name = extractTag(xml, "name");
        String age = extractTag(xml, "age");
        return "{\"name\":\"" + name + "\",\"age\":" + age + "}";
    }

    private String extractTag(String xml, String tag) {
        String start = "<" + tag + ">";
        String end = "</" + tag + ">";
        int s = xml.indexOf(start) + start.length();
        int e = xml.indexOf(end);
        return xml.substring(s, e);
    }
}
