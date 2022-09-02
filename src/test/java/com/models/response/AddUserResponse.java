package com.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddUserResponse extends ApiResponse {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Integer userStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public static Builder builder() {
        return Builder.createBuilder();
    }

    public static final class Builder {

        private AddUserResponse addUserResponse;

        private Builder() {
            addUserResponse = new AddUserResponse();
        }

        private static Builder createBuilder() {
            return new Builder();
        }

        public Builder id(Integer val) {
            addUserResponse.setId(val);
            return this;
        }

        public Builder username(String val) {
            addUserResponse.setUsername(val);
            return this;
        }

        public Builder firstName(String val) {
            addUserResponse.setFirstName(val);
            return this;
        }

        public Builder lastName(String val) {
            addUserResponse.setLastName(val);
            return this;
        }

        public Builder email(String val) {
            addUserResponse.setEmail(val);
            return this;
        }

        public Builder password(String val) {
            addUserResponse.setPassword(val);
            return this;
        }

        public Builder phone(String val) {
            addUserResponse.setPhone(val);
            return this;
        }

        public Builder userStatus(Integer val) {
            addUserResponse.setUserStatus(val);
            return this;
        }

        public AddUserResponse build() {
            return addUserResponse;
        }
    }
}
