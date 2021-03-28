package be.vinci.pae.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import be.vinci.pae.services.DAOFurniture;
import be.vinci.pae.services.DAOType;
import be.vinci.pae.services.DAOUser;
import be.vinci.pae.services.DalServices;
import jakarta.inject.Inject;

public class FurnitureUCCImpl implements FurnitureUCC {

  @Inject
  private DAOFurniture daoFurniture;
  // TODO create classes for Type
  @Inject
  private DAOType daoType;

  @Inject
  private DAOUser daoUser;

  @Inject
  private DalServices dalServices;

  @Override
  public List<FurnitureDTO> getAllFurniture() {
    // TODO DAO
    this.dalServices.startTransaction();
    List<FurnitureDTO> listFurniture = new ArrayList<FurnitureDTO>();
    listFurniture = this.daoFurniture.selectAllFurniture();
    this.dalServices.closeConnection();
    return listFurniture;
  }

  @Override
  public FurnitureDTO addFurniture(FurnitureDTO newFurniture) {
    // TODO DAO
    this.dalServices.startTransaction();
    int id = this.daoFurniture.insertFurniture(newFurniture);
    if (id == -1) {
      this.dalServices.rollbackTransaction();
    } else {
      this.dalServices.commitTransaction();
    }
    newFurniture.setId(id);
    this.dalServices.closeConnection();
    return newFurniture;
  }

  @Override
  public FurnitureDTO modifySellingDate(FurnitureDTO furniture, LocalDate sellingDate) {
    // TODO DAO
    this.dalServices.startTransaction();
    int id = this.daoFurniture.selectFurnitureById(furniture.getId());
    if (id == -1) {
      this.dalServices.rollbackTransaction();
    } else {
      this.daoFurniture.updateSellingDate(id, sellingDate);
      this.dalServices.commitTransaction();
    }
    this.dalServices.closeConnection();
    return furniture;
  }

  @Override
  public FurnitureDTO modifyDepositDate(FurnitureDTO furniture, LocalDate depositDate) {
    // TODO DAO
    this.dalServices.startTransaction();
    int id = this.daoFurniture.selectFurnitureById(furniture.getId());
    if (id == -1) {
      this.dalServices.rollbackTransaction();
    } else {
      this.daoFurniture.updateDepositDate(id, depositDate);
      this.dalServices.commitTransaction();
    }
    this.dalServices.closeConnection();
    return furniture;
  }

  @Override
  public FurnitureDTO modifyWorkshopDate(FurnitureDTO furniture, LocalDate workshopDate) {
    // TODO DAO
    this.dalServices.startTransaction();
    int id = this.daoFurniture.selectFurnitureById(furniture.getId());
    if (id == -1) {
      this.dalServices.rollbackTransaction();
    } else {
      this.daoFurniture.updateWorkshopDate(id, workshopDate);
      this.dalServices.commitTransaction();
    }
    this.dalServices.closeConnection();
    return furniture;
  }

  @Override
  public List<FurnitureDTO> getFurnitureByTypeName(String typeName) {
    // TODO
    this.dalServices.startTransaction();
    List<FurnitureDTO> listFurniture = new ArrayList<FurnitureDTO>();
    // change daoUser by daoType --> create new classes ! TODO
    Type type = (Type) this.daoType.selectTypeByName(typeName);
    if (type == null) {
      this.dalServices.rollbackTransaction();
    } else {
      int idType = type.getId();
      listFurniture = this.daoFurniture.selectFurnitureByTypeName(idType);
      this.dalServices.commitTransaction();
    }
    dalServices.closeConnection();
    return listFurniture;
  }

  @Override
  public List<FurnitureDTO> getFurnitureBySellingPrice(double sellingPrice) {
    // TODO
    this.dalServices.startTransaction();
    List<FurnitureDTO> listFurniture = new ArrayList<FurnitureDTO>();
    listFurniture = this.daoFurniture.selectFurnitureByPrice(sellingPrice);
    dalServices.closeConnection();
    return listFurniture;
  }

  @Override
  public List<FurnitureDTO> getFurnitureByUserName(String userName) {
    // TODO
    this.dalServices.startTransaction();
    List<FurnitureDTO> listFurniture = new ArrayList<FurnitureDTO>();
    User user = (User) this.daoUser.getUserByUsername(userName);
    if (user == null) {
      this.dalServices.rollbackTransaction();
    } else {
      int idUser = user.getId();
      listFurniture = this.daoFurniture.selectFurnitureByBuyerId(idUser);
      this.dalServices.commitTransaction();
    }
    dalServices.closeConnection();
    return listFurniture;
  }

}
