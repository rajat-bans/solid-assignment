package net.media.training.designpattern.builder;

import java.util.List;

import javax.swing.text.html.HTML.Tag;

/**
 * Created by IntelliJ IDEA.
 * User: path
 * Date: Jul 19, 2011
 * Time: 10:04:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class PeopleDataSource {
    public static String getPeopleXml(List<Person> persons) {
        XmlBuilder xmlBuilder = new XmlBuilder();
        xmlBuilder.setXmlVersion(1.0).setEncoding("UTF-8");

        TagBuilder peopleTagBuilder = new TagBuilder().setTagName("People").addAttribute("number", Integer.toString(persons.size()));
        for (Person person : persons) {
            String cityTag = new TagBuilder().setTagName("City").addContent(person.getCity()).build();
            String countryTag = new TagBuilder().setTagName("Country").addContent(person.getCountry()).build();
            String addressTag = new TagBuilder().setTagName("Address").addContent(cityTag + countryTag).build();
            String personTag = new TagBuilder().setTagName("Person")
                                .addAttribute("id", Integer.toString(person.getId()))
                                .addAttribute("name", person.getName())
                                .addContent(addressTag).build();

            peopleTagBuilder.addContent(personTag);
        }

        xmlBuilder.setContent(peopleTagBuilder.build());
        return xmlBuilder.build();
    }
}