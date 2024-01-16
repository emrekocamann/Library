package com.emre.project.library.repo.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SystemUser {
    private  final Integer id;
    private  final  String username;
    private  final  String password;
}
