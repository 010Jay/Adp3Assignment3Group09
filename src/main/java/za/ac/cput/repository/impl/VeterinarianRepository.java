package za.ac.cput.repository.impl;


import za.ac.cput.entity.Dog;
import za.ac.cput.entity.Veterinarian;
import za.ac.cput.factory.VeterinarianFactory;
import za.ac.cput.repository.IRepository;

import java.util.HashSet;
import java.util.Set;

public class VeterinarianRepository implements IRepository<Veterinarian, String> {
  private Set<Veterinarian> veterinarianDb;

  public VeterinarianRepository()
  {
      this.veterinarianDb=new HashSet<>();
  }
  public Veterinarian create(Veterinarian vet)
  {

      this.veterinarianDb.add(vet);
      return vet;
  }

    @Override
    public Veterinarian read(String s) {
        return null;
    }

    public Veterinarian read(Integer Id)
    {
        Veterinarian veterinarian = null;
        for ( Veterinarian vet : veterinarianDb)
        {
            if (Id.equals(vet.getVetId()))
            {
                veterinarian =vet;
                break;
            }
        }
     return veterinarian;
    }
    public Veterinarian update(Veterinarian veterinarian)
    {
        Veterinarian oldVeterinarian = read(veterinarian.getVetId());
        if (oldVeterinarian!=null)
        {
            veterinarianDb.remove(oldVeterinarian);
            veterinarianDb.add(veterinarian);
        }

      return veterinarian;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    public void delete(Integer Id)
    {
        Veterinarian veterinarian = read(Id);
        if (veterinarian!=null)
        {

            veterinarianDb.remove(veterinarian);
        }
    }

    public Set<Veterinarian> getAll() {
        return this.veterinarianDb;
    }





}
