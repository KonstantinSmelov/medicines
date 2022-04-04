package org.example.dao;

import org.example.additional.SortListOfMedicine;
import org.example.entity.Medicine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicineDAO {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public List<Medicine> getAllMedicines() {

        Session session = entityManager.unwrap(Session.class);

        List<Medicine> allMedicinesList = session.createQuery("from Medicine", Medicine.class).getResultList();

        return allMedicinesList;
    }

    @Transactional
    public Medicine getMedicine(int id) {
        Session session = entityManager.unwrap(Session.class);
        return (Medicine) session.createQuery("from Medicine where id = :id").setParameter("id", id).getSingleResult();

    }

    @Transactional
    public List<Medicine> getAllMedicinesById() {

        Session session = entityManager.unwrap(Session.class);
        List<Medicine> allMedicinesList = session.createQuery("from Medicine order by id asc", Medicine.class).getResultList();

        return allMedicinesList;
    }
//
//    @Transactional
//    public List<Medicine> getAllMedicinesByExpData() {
//
//        Session session = entityManager.unwrap(Session.class);
//        List<Medicine> allMedicinesList = session.createQuery("from Medicine", Medicine.class).getResultList();
//
//
//        return SortListOfMedicine.sortByExpData(allMedicinesList);
//    }
//
//    @Transactional
//    public List<Medicine> getAllMedicinesByName() {
//
//        Session session = entityManager.unwrap(Session.class);
//        List<Medicine> allMedicinesList = session.createQuery("from Medicine order by medicine desc", Medicine.class).getResultList();
//
////        return SortListOfMedicine.sortByName(allMedicinesList);
//        return allMedicinesList;
//    }
//
//    @Transactional
//    public List<Medicine> getAllMedicinesByFound(String medicineName) {
//
//        Session session = entityManager.unwrap(Session.class);
//        List<Medicine> allMedicinesList = session.createQuery("from Medicine where medicine = :name", Medicine.class).setParameter("name", medicineName).getResultList();
//
////        List<Medicine> notFoundList = new ArrayList<>();
////        notFoundList.add(new Medicine("не найден", "--", "--", "--", 0));
////
////        if(SortListOfMedicine.sortByFound(allMedicinesList, medicineName).isEmpty() && !medicineName.isEmpty())
////            return notFoundList;
////
////        return SortListOfMedicine.sortByFound(allMedicinesList, medicineName);
//        return allMedicinesList;
//    }

    @Transactional
    public void saveMedicine(Medicine medicine) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(medicine);
    }

    @Transactional
    public Medicine updateMedicine(int medId) {
        Session session = entityManager.unwrap(Session.class);
        Medicine medicine = session.get(Medicine.class, medId);;
        session.saveOrUpdate(medicine);
        return medicine;
    }

    @Transactional
    public void deleteMedicine(int medId) {
        Session session = entityManager.unwrap(Session.class);
        Query<Medicine> query = session.createQuery("delete from Medicine where id = :Id").setParameter("Id", medId);
//        query.setParameter("Id", medId);
        query.executeUpdate();
    }
}
