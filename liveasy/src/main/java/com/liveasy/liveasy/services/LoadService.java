package com.liveasy.liveasy.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.liveasy.liveasy.entities.Load;

@Service
public class LoadService {
    
	@Autowired
    private JdbcTemplate jdbcTemplate;
    
    public Load addLoad(Load load) {
        String query = "INSERT INTO load(loadingPoint,unloadingPoint,productType,truckType,noOfTrucks,weight,comment,shipperId,Date) values('"
                + load.getLoadingPoint() + "','" + load.getUnloadingPoint() + "','" + load.getProductType() + "','"
                + load.getTruckType() + "','" + load.getNoOfTrucks() + "','" + load.getWeight() + "','"
                + load.getComment() + "','" + load.getShipperId() + "','" + load.getDate() + "');";
        this.jdbcTemplate.update(query);
        return load;
    }

    public List<Map<String, Object>> getLoadByShipperId(String shipperId) {
        String query = "SELECT * FROM load WHERE shipperId='" + shipperId + "'";
        List<Map<String, Object>> load = this.jdbcTemplate.queryForList(query);
        return load;
    }

    public List<Map<String, Object>> getLoadByLoadId(String loadId) {
        String query = "SELECT * FROM load WHERE loadId='" + loadId + "';";
        List<Map<String, Object>> load = this.jdbcTemplate.queryForList(query);
        return load;
    }

    public int putLoadByLoadId(String loadId,Load load) {
        String query = "UPDATE load SET loadingPoint='" + load.getLoadingPoint() + "',unloadingPoint='"
                + load.getUnloadingPoint() + "',productType='" + load.getProductType() + "',truckType='"
                + load.getTruckType() + "',noOfTrucks='" + load.getNoOfTrucks() + "',weight='" + load.getWeight()
                + "',comment='" + load.getComment() + "',shipperId='" + load.getShipperId() + "',Date='"
                + load.getDate() + "' WHERE loadId="+Integer.parseInt(loadId)+";";
        int res = this.jdbcTemplate.update(query);
        return res;
    }

    public int deleteLoadByLoadId(String loadId) {
        String query = "DELETE FROM load WHERE loadId='" + loadId + "';";
        int load = this.jdbcTemplate.update(query);
        return load;
    }
}
