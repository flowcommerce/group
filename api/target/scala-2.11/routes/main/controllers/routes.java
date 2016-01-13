
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mikeroth/GitRepos/group/api/conf/routes
// @DATE:Tue Jan 12 06:57:55 EST 2016

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseMemberships Memberships = new controllers.ReverseMemberships(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseGroups Groups = new controllers.ReverseGroups(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHealthchecks Healthchecks = new controllers.ReverseHealthchecks(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseMemberships Memberships = new controllers.javascript.ReverseMemberships(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseGroups Groups = new controllers.javascript.ReverseGroups(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHealthchecks Healthchecks = new controllers.javascript.ReverseHealthchecks(RoutesPrefix.byNamePrefix());
  }

}
