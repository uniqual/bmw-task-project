package com.bmw.dto.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import java.io.Serializable;

public class UserRequestDto implements Serializable {

    private final Long id;
    private final String name;
    private final String username;

    @Email
    private final String email;
    private final Address address;
    private final String phone;
    private final String website;
    private final Company company;

    @JsonCreator
    public UserRequestDto(@JsonProperty("id") Long id,
                          @JsonProperty("name") String name,
                          @JsonProperty("username") String username,
                          @JsonProperty("email") String email,
                          @JsonProperty("address") Address address,
                          @JsonProperty("phone") String phone,
                          @JsonProperty("website") String website,
                          @JsonProperty("company") Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Company getCompany() {
        return company;
    }

    public static class Address implements Serializable {

        private final String street;
        private final String suite;
        private final String city;
        private final String zipcode;
        private final Geo geo;

        @JsonCreator
        public Address(@JsonProperty("street") String street,
                       @JsonProperty("suite") String suite,
                       @JsonProperty("city") String city,
                       @JsonProperty("zipcode") String zipcode,
                       @JsonProperty("geo") Geo geo) {
            this.street = street;
            this.suite = suite;
            this.city = city;
            this.zipcode = zipcode;
            this.geo = geo;
        }

        public String getStreet() {
            return street;
        }

        public String getSuite() {
            return suite;
        }

        public String getCity() {
            return city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public Geo getGeo() {
            return geo;
        }
    }

    public static class Geo implements Serializable {

        private final String lat;
        private final String lng;

        @JsonCreator
        public Geo(@JsonProperty("lat") String lat,
                   @JsonProperty("lng") String lng) {
            this.lat = lat;
            this.lng = lng;
        }

        public String getLat() {
            return lat;
        }

        public String getLng() {
            return lng;
        }
    }

    public static class Company implements Serializable {

        private final String name;
        private final String catchPhrase;
        private final String bs;

        @JsonCreator
        public Company(@JsonProperty("name") String name,
                       @JsonProperty("catchPhrase") String catchPhrase,
                       @JsonProperty("bs") String bs) {
            this.name = name;
            this.catchPhrase = catchPhrase;
            this.bs = bs;
        }

        public String getName() {
            return name;
        }

        public String getCatchPhrase() {
            return catchPhrase;
        }
        public String getBs() {
            return bs;
        }
    }
}
