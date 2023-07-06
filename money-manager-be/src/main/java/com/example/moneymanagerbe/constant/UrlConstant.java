package com.example.moneymanagerbe.constant;

public class UrlConstant {

  public static class Auth {
    private static final String PRE_FIX = "/auth";

    public static final String LOGIN = PRE_FIX + "/login";
    public static final String REGISTER = PRE_FIX + "/register";
    public static final String LOGOUT = PRE_FIX + "/logout";
    public static final String RESET_PASSWORD = PRE_FIX + "/forgot-password";

    private Auth() {
    }
  }

  public static class User {
    private static final String PRE_FIX = "/user";

    public static final String GET_USERS = PRE_FIX;
    public static final String GET_USER = PRE_FIX + "/{userId}";
    public static final String GET_CURRENT_USER = PRE_FIX + "/current";
    public static final String UPDATE_USER = PRE_FIX;
    public static final String CHANGE_PASSWORD = PRE_FIX + "/change-password";

    private User() {
    }
  }

  public static class Budget {
    private static final String PRE_FIX = "/budget";

    public static final String GET_BUDGETS = PRE_FIX;
    public static final String POST_NEW_BUDGET = PRE_FIX;
    public static final String UPDATE_NAME_BUDGET = PRE_FIX + "/update-name/{id}";
    public static final String DELETE_BUDGETS = PRE_FIX + "/{id}";

    private Budget() {
    }
  }

  public static class Category {
    private static final String PRE_FIX = "/category";

    public static final String GET_CATEGORIES = PRE_FIX;
    public static final String POST_NEW_CATEGORY = PRE_FIX;
    public static final String DELETE_CATEGORY = PRE_FIX + "/{id}";
  }

  public static class Transaction {
    private static final String PRE_FIX = "/transaction";

    public static final String GET_TRANSACTIONS = PRE_FIX;
    public static final String GET_TRANSACTIONS_BY_CURRENT_USER = PRE_FIX + "/me";
    public static final String GET_TRANSACTIONS_BY_BUDGET = PRE_FIX + "/by-budget/{budgetId}";
    public static final String GET_TRANSACTIONS_BY_CATEGORY = PRE_FIX + "/by-category/{categoryId}";
    public static final String GET_TRANSACTIONS_BY_CATEGORY_TYPE = PRE_FIX + "/by-category-type/{type}";
    public static final String POST_TRANSACTION = PRE_FIX;
    public static final String PATCH_TRANSACTION = PRE_FIX + "/{id}";
    public static final String DELETE_TRANSACTION = PRE_FIX + "/{id}";

    private Transaction() {
    }
  }

}
