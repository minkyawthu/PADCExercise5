package com.example.mkt.padcexercise5.data.models;

import com.example.mkt.padcexercise5.data.vos.AttractVO;
import com.example.mkt.padcexercise5.utils.CommonInstances;
import com.example.mkt.padcexercise5.utils.JsonUtils;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkt on 7/7/2016.
 */
public class AttractModel {

    private static final String DUMMY_ATTRACT_LIST = "myanmar_attractions.json";

    private static AttractModel objInstance;

    private List<AttractVO> attractList;


    public AttractModel() {
        attractList = initilizeAttractList();
    }

    public static AttractModel getObjInstance() {

        if (objInstance == null) {
            objInstance = new AttractModel();
        }
        return objInstance;
    }

    public List<AttractVO> initilizeAttractList() {

        List<AttractVO> attractList = new ArrayList<AttractVO>();
        try {
            String dummyAttractList = JsonUtils.getObjInstace().loadDummyData(DUMMY_ATTRACT_LIST);
            Type listtype = new TypeToken<List<AttractVO>>() {
            }.getType();
            attractList = CommonInstances.getGsonInstance().fromJson(dummyAttractList, listtype);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return attractList;
    }

    public List<AttractVO> getAttractList() {
        return attractList;
    }

    public AttractVO getAttractByTitle(String attractTitle) {
        for (AttractVO attract : attractList) {
            if (attract.getAttractTitle().equals(attractTitle)) {
                return attract;
            }
        }
        return null;
    }

}
