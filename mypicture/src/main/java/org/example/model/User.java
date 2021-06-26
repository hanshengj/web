package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-06-24
 * Time: 9:28
 */
@Setter
@Getter
@ToString
public class User {
    private Integer id;
    private String name;
    private String password;
}
