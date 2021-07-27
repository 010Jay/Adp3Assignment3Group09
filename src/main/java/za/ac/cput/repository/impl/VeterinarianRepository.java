package za.ac.cput.repository.impl;


import za.ac.cput.entity.Dog;
import za.ac.cput.entity.Veterinarian;
import za.ac.cput.factory.VeterinarianFactory;

import java.util.HashSet;
import java.util.Set;

public class VeterinarianRepository {
  private Set<Veterinarian> veterinarianDb;

  public VeterinarianRepository()
  {
      this.veterinarianDb=new HashSet<>();
  }
  public Veterinarian create(Veterinarian vet)
  {

      this.veterinarianDb.add(veterinarian);
      return veterinarian;
  }
    public Veterinarian read(int Id)
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
    public void delete(Integer Id)
    {
        Veterinarian veterinarian = read(Id);
        if (vetId!=null)
        {

            veterinarianDb.remove(veterinarian);
        }

        return veterinarian;
    }

    public Set<Veterinarian> getAll() {
        return dogDB;
    }





}
