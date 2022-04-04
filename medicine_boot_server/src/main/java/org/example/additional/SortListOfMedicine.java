package org.example.additional;

import org.example.entity.Medicine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListOfMedicine {

    public static Integer myRevers(String str) {            //преобразование строки ММ.ГГГГ, в число ГГГГММ для возможности сортировки
        StringBuilder sb = new StringBuilder(str);
        StringBuilder sbToOut = new StringBuilder("");

        sb.deleteCharAt(2);
        sbToOut.append(sb.charAt(2));
        sbToOut.append(sb.charAt(3));
        sbToOut.append(sb.charAt(4));
        sbToOut.append(sb.charAt(5));
        sbToOut.append(sb.charAt(0));
        sbToOut.append(sb.charAt(1));

        return Integer.parseInt(sbToOut.toString());
    }

    public static List<Medicine> sortByFound(List<Medicine> allMedicineList, String medicineName) {

        List<Medicine> foundMedicine = new ArrayList<>();

        for (Medicine medicine : allMedicineList)
            if (medicine.getMedicine().equals(medicineName)) {
                foundMedicine.add(medicine);
            }

        return foundMedicine;
    }

    public static List<Medicine> sortByName(List<Medicine> allMedicineList) {

        Collections.sort(allMedicineList);

        return allMedicineList;
    }

    public static List<Medicine> sortByExpData(List<Medicine> allMedicineList) {

        for (Medicine med : allMedicineList) {

            med.setIntExpiration(myRevers(med.getExpiration()));

        }

//        Collections.sort(allMedicineList, (m1, m2) -> m1.getIntExpiration().compareTo(m2.getIntExpiration()));
        Collections.sort(allMedicineList, Comparator.comparing(Medicine::getIntExpiration));

        return allMedicineList;
    }

    public static List<Medicine> sortById(List<Medicine> allMedicineList) {

        allMedicineList.sort((m1, m2)
                -> {
            if (m1.getId() == m2.getId()) return 0;
            if (m1.getId() < m2.getId()) return -1;
            else return 1;
        });

        return allMedicineList;
    }
}
