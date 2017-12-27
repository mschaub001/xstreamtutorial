package com.example.ms.xstreamtutorial;

import com.thoughtworks.xstream.XStream;

class PersonList {

    Person[] personList = null;

    PersonList(int count) {
        int i;
        personList = new Person[count];
        for (i = 0; i < count; i++) {
            personList[i] = new Person("John", "Dow_" + i, null, null);
            System.out.println("\nPerson: John Dow" + i);
        }
        System.out.println("\n\n");
    }

    PersonList(String xml) {
        fromXML(xml);
    }

    String toXML() {
        XStream xstream = new XStream();
        xstream.allowTypesByWildcard(new String[] {
                "com.example.ms.xstreamtutorial.**"
        });
        xstream.alias("Person", Person.class);
        xstream.alias("PersonList", PersonList.class);
        String xml = xstream.toXML(personList);
        System.out.println("\nXML:\n" + xml);
        return xml;
    }

    void fromXML(String xml) {
        XStream xstream = new XStream();
        xstream.allowTypesByWildcard(new String[] {
                "com.example.ms.xstreamtutorial.**"
        });
        xstream.alias("Person", Person.class);
        xstream.alias("PersonList", PersonList.class);
        personList = (Person[]) xstream.fromXML(xml);
        System.out.println("\nXML:\n" + xml);
    }
}