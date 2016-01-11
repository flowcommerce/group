
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mikeroth/GitRepos/group/api/conf/routes
// @DATE:Mon Jan 11 15:11:43 EST 2016

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseGroups Groups = new controllers.ReverseGroups(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHealthchecks Healthchecks = new controllers.ReverseHealthchecks(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseGroups Groups = new controllers.javascript.ReverseGroups(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHealthchecks Healthchecks = new controllers.javascript.ReverseHealthchecks(RoutesPrefix.byNamePrefix());
  }

}
