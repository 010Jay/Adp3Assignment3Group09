package za.ac.cput.repository.impl;



import za.ac.cput.entity.Dog;
import za.ac.cput.entity.DogDescription;

import java.util.HashSet;
import java.util.Set;

public class DogDescriptionRepository implements IDogDescriptionRepository  {


    //Attributes
    private static DogDescriptionRepository repository = null;
    private Set<DogDescription> dogDB;

    //Constructor
    public DogDescriptionRepository()
    {
        this.dogDB = new HashSet<>();
    }

    //Singleton
    public static DogDescriptionRepository getRepository()
    {
        if(repository == null)
        {
            repository = new DogDescriptionRepository();
        }

        return repository;
    }


    @Override
    public DogDescription create(DogDescription dogDescription) {

        this.dogDB.add(dogDescription);
        return dogDescription;
    }

    @Override
    public DogDescription read(Integer id) {

        DogDescription dogDescription  = null;

        for(DogDescription d: dogDB)
        {
            if(id.equals(d.getId()))
            {
                dogDescription = d;
                break;
            }
        }

        return dogDescription;
    }

    @Override
    public DogDescription update(DogDescription dogDescription) {


        DogDescription oldDog = read(dogDescription.getId());

        if(oldDog != null)
        {
            dogDB.remove(oldDog);
            dogDB.add(dogDescription);

            return dogDescription;
        }



        return dogDescription;
    }

    @Override
    public boolean delete(Integer integer) {

        DogDescription dogDescription = read(integer);

        if(dogDescription != null)
        {
            dogDB.remove(dogDescription);
            return true;
        }
        return false;
    }

    @Override
    public Set<DogDescription> getAll(){return dogDB;} {

    }

    @Override
    public Integer getSize() {return dogDB.size();} {

    }
}
