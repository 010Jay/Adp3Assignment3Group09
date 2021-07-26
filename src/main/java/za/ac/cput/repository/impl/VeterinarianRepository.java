package za.ac.cput.repository.impl;


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
  public Veterinarian create(String name)
  {
      Veterinarian veterinarian = VeterinarianFactory.createVeterinarian(name);
      this.veterinarianDb.add(veterinarian);
      return veterinarian;
  }
    public Veterinarian read(int vetId)
    {
        Veterinarian veterinarian = null;
        for ( Veterinarian vet : veterinarianDb)
        {
            if (vet.get)
        }
     return null;
    }
    public Veterinarian update(Veterinarian veterinarian)
    {
      return null;
    }
    public Veterinarian delete(Integer vetId)
    {

    }



}
