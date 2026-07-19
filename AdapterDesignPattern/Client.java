public class Client {
    public static void main(String[] args) {
        XmlDataService xmlService = new XmlDataService();
        IJsonService adapter = new XmlToJsonAdapter(xmlService);

        System.out.println("XML: " + xmlService.getXmlData());
        System.out.println("JSON: " + adapter.getJsonData());
    }
}
