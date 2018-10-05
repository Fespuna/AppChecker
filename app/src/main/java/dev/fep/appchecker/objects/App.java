package dev.fep.appchecker.objects;

/**
 * Created by Ferran on 23/09/2018.
 */

public class App {

    String app_name, app_package,vm;
    int published;

    public App(String app_name, String app_package, int published, String vm) {
        this.app_name = app_name;
        this.app_package = app_package;
        this.published = published;
        this.vm = vm;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getApp_package() {
        return app_package;
    }

    public void setApp_package(String app_package) {
        this.app_package = app_package;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public String getVm() {
        return vm;
    }

    public void setVm(String vm) {
        this.vm = vm;
    }
}
