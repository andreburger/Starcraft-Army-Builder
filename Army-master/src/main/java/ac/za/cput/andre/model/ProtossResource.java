package ac.za.cput.andre.model;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by student on 2015/05/24.
 */
public class ProtossResource extends ResourceSupport {
    private Long resID;
    private String armyName;
    private ArrayList<HashMap<String,String>> armyUnits;

    private ProtossResource()
    {

    }

    public Long getResID()
    {
        return resID;
    }

    public String getArmyName()
    {
        return armyName;
    }

    public ArrayList<HashMap<String,String>> getArmyUnits()
    {
        return armyUnits;
    }

    public ProtossResource(Builder builder)
    {
        this.resID = builder.resID;
        this.armyName = builder.armyName;
    }

    public static class Builder{
        private Long resID;
        private String armyName;
        private ArrayList<HashMap<String,String>> armyUnits;

        public Builder(String name) {
            this.armyName = name;
        }

        public Builder resid(Long value){
            this.resID=value;
            return this;
        }


        public Builder armyName(String value){
            this.armyName=value;
            return this;
        }
        public Builder armyUnits(ArrayList<HashMap<String,String>> value)
        {
            this.armyUnits = value;
            return this;
        }

        public ProtossResource build(){
            return new ProtossResource(this);
        }

    }

}
