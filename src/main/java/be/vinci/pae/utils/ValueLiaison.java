package be.vinci.pae.utils;

public class ValueLiaison {

  public static final String ADMIN_STRING = "admin";
  public static final String CLIENT_STRING = "client";
  public static final String ANTIQUAIRE_STRING = "antiquaire";
  public static final int ADMIN_INT = 2;
  public static final int CLIENT_INT = 0;
  public static final int ANTIQUAIRE_INT = 1;
  public static final String CANCELED_OPTION_STRING = "annulee";
  public static final String FINISHED_OPTION_STRING = "finie";
  public static final String RUNNING_OPTION_STRING = "en cours";
  public static final int CANCELED_OPTION_INT = 0;
  public static final int FINISHED_OPTION_INT = 2;
  public static final int RUNNING_OPTION_INT = 1;
  public static final String[] CONDITION_FURNITURE = {"propose", "ne_convient_pas", "achete",
      "emporte_par_patron", "en_restauration", "en_magasin", "en_vente"};

  /**
   * Change the user type form string into a integer.
   *
   * @param type type of user as string
   * @return integer of the user type
   */
  public static int stringToIntUserType(String type) {
    switch (type.toLowerCase()) {
      case CLIENT_STRING:
        return CLIENT_INT;
      case ANTIQUAIRE_STRING:
        return ANTIQUAIRE_INT;
      case ADMIN_STRING:
        return ADMIN_INT;
      default:
        throw new BusinessException("Le type n'existe pas");
    }
  }

  /**
   * Change the user type form integer into a string.
   *
   * @param type type of user as integer
   * @return string of the user type
   */
  public static String intToStringUserType(int type) {
    switch (type) {
      case CLIENT_INT:
        return CLIENT_STRING;
      case ANTIQUAIRE_INT:
        return ANTIQUAIRE_STRING;
      case ADMIN_INT:
        return ADMIN_STRING;
      default:
        throw new BusinessException("Le type n'existe pas");
    }
  }

  /**
   * Valid the string of the user type.
   *
   * @param type type of user as string
   * @return boolean of valid type
   */
  public static boolean isValidUserType(String type) {
    switch (type.toLowerCase()) {
      case CLIENT_STRING:
      case ANTIQUAIRE_STRING:
      case ADMIN_STRING:
        return true;
      default:
        return false;
    }
  }

  /**
   * Valid the integer of the user type.
   *
   * @param type type of user as integer
   * @return boolean of valid type
   */
  public static boolean isValidUserType(int type) {
    switch (type) {
      case CLIENT_INT:
      case ANTIQUAIRE_INT:
      case ADMIN_INT:
        return true;
      default:
        return false;
    }
  }

  /**
   * Change the option type form string into a integer.
   *
   * @param type type of option as string
   * @return integer of the option type
   */
  public static int stringToIntOption(String type) {
    switch (type.toLowerCase()) {
      case RUNNING_OPTION_STRING:
        return RUNNING_OPTION_INT;
      case FINISHED_OPTION_STRING:
        return FINISHED_OPTION_INT;
      case CANCELED_OPTION_STRING:
        return CANCELED_OPTION_INT;
      default:
        throw new BusinessException("Le type n'existe pas");
    }
  }

  /**
   * Change the option type form integer into a string.
   *
   * @param type type of option as integer
   * @return string of the option type
   */
  public static String intToStringOption(int type) {
    switch (type) {
      case RUNNING_OPTION_INT:
        return RUNNING_OPTION_STRING;
      case FINISHED_OPTION_INT:
        return FINISHED_OPTION_STRING;
      case CANCELED_OPTION_INT:
        return CANCELED_OPTION_STRING;
      default:
        throw new BusinessException("Le type n'existe pas");
    }
  }

  /**
   * Valid the string of the option type.
   *
   * @param type type of option as string
   * @return boolean of valid type
   */
  public static boolean isValidOption(String type) {
    switch (type.toLowerCase()) {
      case RUNNING_OPTION_STRING:
      case FINISHED_OPTION_STRING:
      case CANCELED_OPTION_STRING:
        return true;
      default:
        return false;
    }
  }

  /**
   * Valid the integer of the option type.
   *
   * @param type type of option as integer
   * @return boolean of valid type
   */
  public static boolean isValidOption(int type) {
    switch (type) {
      case RUNNING_OPTION_INT:
      case FINISHED_OPTION_INT:
      case CANCELED_OPTION_INT:
        return true;
      default:
        return false;
    }
  }

  public static String intToStringFurniture(int condition) {
    return CONDITION_FURNITURE[condition];
  }

  public static int StringToIntFurniture(String condition) {
    for (int i = 0; i < CONDITION_FURNITURE.length; i++) {
      if (CONDITION_FURNITURE[i].equals(condition))
        return i;
    }
    return -1;
  }

}
