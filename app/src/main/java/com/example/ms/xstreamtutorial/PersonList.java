package com.example.ms.xstreamtutorial;

import com.thoughtworks.xstream.XStream;

class PersonList {

    Person[] personList = null;

    PersonList(int count) {
        int i;
        personList = new Person[count];
        for (i = 0; i < count; i++) {
            personList[i] = new Person("John", "Dow_" + i, null, null);
            System.out.println("\nPerson: " + personList[i].getFirstname() + ", " + personList[i].getLastname());
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

    Person[] searchPerson(String searchFor) {
        int cnt = 0;
        Person[] searchResult = new Person[1000]; // shrink later

        for ( int i=0; i<personList.length; i++) {
            if (       (personList[i].getFirstname() != null && personList[i].getFirstname().contains(searchFor))
                    || (personList[i].getLastname() != null && personList[i].getLastname().contains(searchFor))
                    || (personList[i].getPhone() != null && personList[i].getPhone().contains(searchFor))
                    || (personList[i].getEmail() != null && personList[i].getEmail().contains(searchFor))) {
                searchResult[cnt++] = personList[i];
            }
        }
        Person[] result = new Person[cnt];
        System.arraycopy(searchResult, 0, result, 0, cnt);
        return result;
    }
}