package bdd.pojo;

import java.util.List;

public class Courses {

    private List<WebAutomation> webAutomation;
    private List<api> api;
    private List<mobile> mobile;

    public List<WebAutomation> getWebAutomation() {
        return webAutomation;
    }

    public void setWebAutomation(List<WebAutomation> webAutomation) {
        this.webAutomation = webAutomation;
    }

    public List<bdd.pojo.api> getApi() {
        return api;
    }

    public void setApi(List<bdd.pojo.api> api) {
        this.api = api;
    }

    public List<bdd.pojo.mobile> getMobile() {
        return mobile;
    }

    public void setMobile(List<bdd.pojo.mobile> mobile) {
        this.mobile = mobile;
    }
}
