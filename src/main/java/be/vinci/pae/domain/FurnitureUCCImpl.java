package be.vinci.pae.domain;

import java.util.List;
import be.vinci.pae.services.DAOFurniture;
import be.vinci.pae.services.DAOOption;
import be.vinci.pae.services.DAOPicture;
import be.vinci.pae.services.DAOUser;
import jakarta.inject.Inject;

public class FurnitureUCCImpl implements FurnitureUCC {
  
  @Inject
  private DAOPicture daoPicture;
  @Inject
  private DAOFurniture daoFurniture;
  @Inject
  private DAOOption daoOption;
  @Inject
  private DAOUser daoUser;

  @Override
  public List<FurnitureDTO> getAllFurniture() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public FurnitureDTO addFurniture(FurnitureDTO furniture) {
    // TODO Auto-generated method stub
    return null;
  }

}
