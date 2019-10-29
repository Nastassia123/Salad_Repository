package com.epam.ta.salad.Repository.SQLService;

import Entities.Vegetable;
import SaladOperatios.VegetablesFilter;
import com.epam.ta.parking.util.NullCheckUtil;
import com.epam.ta.salad.Repository.SQLRepository.VegetableRepositoryImpl;
import com.epam.ta.salad.Repository.Service.VegetableService;
import exceptions.NullVegetableException;

import java.sql.SQLException;
import java.util.List;

public class VegetableServiceImpl implements VegetableService {

    private final VegetableRepositoryImpl vegetableRepositoryImpl;

    public VegetableServiceImpl(VegetableRepositoryImpl vegetableRepositoryImpl) {
        this.vegetableRepositoryImpl = vegetableRepositoryImpl;
    }

    @Override
    public Vegetable add(Vegetable vegetable) throws SQLException, ClassNotFoundException, NullVegetableException {
        Vegetable addVegetable = null;
        if (null != vegetable) {
            if (!NullCheckUtil.notNullCheck(vegetable.getName()) & (!NullCheckUtil.notNullCheck(vegetable.getId(),
                    (int) vegetable.getWeight(), (int) vegetable.getCalories()))) {
                throw new NullVegetableException("Vegetable contains null data");
            }

            try {
                VegetableRepositoryImpl vegetableRepositoryImpl = new VegetableRepositoryImpl();
                vegetableRepositoryImpl.add(vegetable);
                addVegetable = vegetable;
            } catch (SQLException e) {
                System.out.println("Unable to add a vegetable");
            }
        }
        return addVegetable;
    }


    public Vegetable remove (Vegetable vegetable) throws SQLException {
        try {
            this.vegetableRepositoryImpl.remove(this.getObjects(vegetable));

        } catch (Exception e) {
            System.out.println("Unable to remove object");
        }
        return vegetable;
    }




    /*

    @Override
    public Vegetable update(Vegetable vegetable) throws SQLException {
        return null;
    }


        @Override
        public Vegetable getObjects (Vegetable vegetable) throws SQLException {
            if (vegetable.getCalories();
        }

        @Override
        public Vegetable getVegetablesFromFilter (List<Vegetable> vegetableList){
            try {
                VegetablesFilter vegetablesFilter = new VegetablesFilter();
                vegetablesFilter.findVegetableByParameters().;
            }
        }


     */
    }
