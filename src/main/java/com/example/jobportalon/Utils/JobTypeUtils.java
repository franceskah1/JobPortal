package com.example.jobportalon.Utils;

import com.example.jobportalon.Entity.JobType;
import com.example.jobportalon.Exception.NotFoundException;

public class JobTypeUtils {

    public static JobType getJobType(String jobType){
        if (jobType.equalsIgnoreCase(JobType.PartTime.name())){
            return JobType.PartTime;
        }
        if (jobType.equalsIgnoreCase(JobType.FullTime.name())){
            return JobType.FullTime;
        }
        if (jobType.equalsIgnoreCase(JobType.Contract.name())){
            return JobType.Contract;
        }

       else{
        throw new NotFoundException("This JobType is not valid. Select a JobType from list!\"");
    }


    }

}
