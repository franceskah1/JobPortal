package com.example.jobportalon.Utils;

import com.example.jobportalon.Entity.Application_status;
import com.example.jobportalon.Entity.JobType;
import com.example.jobportalon.Exception.NotFoundException;

public class ApplicationStatusUtils {
    public static Application_status getApplication_status(String application_status) {
        if (application_status.equalsIgnoreCase(Application_status.Applied.name())) {
            return Application_status.Applied;
        }
        if (application_status.equalsIgnoreCase(Application_status.Rejected.name())) {
            return Application_status.Rejected;
        }
        if (application_status.equalsIgnoreCase(Application_status.Hired.name())) {
            return Application_status.Hired;
        }
        if (application_status.equalsIgnoreCase(Application_status.Shortlisted.name())) {
            return Application_status.Shortlisted;
        }
        else {
            throw new NotFoundException("This ApplicationStatus is not found!");
        }
    }
}