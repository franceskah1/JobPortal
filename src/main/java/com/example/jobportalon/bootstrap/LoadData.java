package com.example.jobportalon.bootstrap;

import com.example.jobportalon.Entity.Role;
import com.example.jobportalon.Repository.RoleRepo;
import com.example.jobportalon.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoadData implements CommandLineRunner {
    private final UserRepo usersRepository;

    private final RoleRepo roleRepositories;

    @Override
    public void run(String... args) throws Exception {
        saveUsers();

    }

    private void saveUsers() {
        if (roleRepositories.count() == 0) {
            Role savedEmployerRole = roleRepositories.save(new Role("EMPLOYER"));
            Role savedJobSeekerRole = roleRepositories.save(new Role("JOB SEEKER"));
            Role savedAdminRole = roleRepositories.save(new Role("ADMIN"));
        }
    }
}
