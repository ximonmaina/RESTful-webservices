package com.learnrest.rest.webservices.restfulwebservices.patient.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnrest.rest.webservices.restfulwebservices.jwt.*;
import com.learnrest.rest.webservices.restfulwebservices.patient.domain.Patient;
import com.learnrest.rest.webservices.restfulwebservices.patient.service.PatientService;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Date;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@RunWith(SpringRunner.class)
@SpringBootConfiguration
@WebMvcTest(controllers = PatientController.class)
@EnableAutoConfiguration(exclude = {JWTWebSecurityConfig.class, JwtTokenUtil.class, JwtUnAuthorizedResponseAuthenticationEntryPoint.class,
        JwtRelationalUserDetailsService.class, JwtUserDetails.class, JwtTokenAuthorizationOncePerRequestFilter.class} )
@Import(value = {JWTWebSecurityConfig.class, JwtTokenUtil.class, JwtUnAuthorizedResponseAuthenticationEntryPoint.class,
        JwtRelationalUserDetailsService.class, JwtUserDetails.class, JwtTokenAuthorizationOncePerRequestFilter.class})
public class PatientControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PatientService patientService;


    @Test
   public void whenValidUrlAndMethodAndContentType_thenReturns200() throws Exception {

        Patient patient = new Patient("Simon", "Maina","Kariuki", 12345678, new Date(),  22, "Male","Kenya","Kiambu", 623413423, "776-00290", "maina@gmail.com", new Date(), "KOOQ");

        mockMvc.perform(post("/patient/addpatient")
                .content(objectMapper.writeValueAsString(patient))
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
  public void whenValidInput_thenMapsToBusinessModel() throws Exception {

        Patient patient = new Patient("Simon", "Maina","Kariuki", 12345678, new Date(),
                22, "Male","Kenya","Kiambu", 623413423, "776-00290",
                "maina@gmail.com", new Date(), "KOOQ");

        mockMvc.perform(post("/patient/addpatient")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(patient)))
                .andExpect(status().isOk());

        ArgumentCaptor<Patient> patientCaptor = ArgumentCaptor.forClass(Patient.class);
        verify(patientService, times(1)).savePatient(patientCaptor.capture());
        assertThat(patientCaptor.getValue().getPatientFirstName(), equalTo("Simon"));
        assertThat(patientCaptor.getValue().getPatientMiddleName(), equalTo("Kariuki"));
        assertThat(patientCaptor.getValue().getPatientLastName(), equalTo("Maina"));
        assertThat(patientCaptor.getValue().getPatientIdentityNumber(), equalTo(12345678));
        assertThat(patientCaptor.getValue().getPatientDateOfBirth(), equalTo(new Date()));
        assertThat(patientCaptor.getValue().getPatientAge(),equalTo(22));
        assertThat(patientCaptor.getValue().getPatientCountry(), equalTo("Kenya"));
        assertThat(patientCaptor.getValue().getPatientCounty(),equalTo("Kiambu"));
        assertThat(patientCaptor.getValue().getPatientPhoneNumber(), equalTo(623413423));
        assertThat(patientCaptor.getValue().getPatientAddress(), equalTo("maina@gmail.com"));
        assertThat(patientCaptor.getValue().getPatientJoinDate(), equalTo(new Date()));

    }

    @Test
   public void whenValidInput_thenReturnsUserResource() throws Exception {
        Patient patient = new Patient("Simon", "Maina","Kariuki", 12345678, new Date(),
                22, "Male","Kenya","Kiambu", 623413423, "776-00290",
                "maina@gmail.com", new Date(), "KOOQ");

        MvcResult mvcResult = mockMvc.perform(post("/patient/addpatient")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(patient)))
                .andExpect(status().isOk())
                .andReturn();

        Patient expectedResponseBody = patient;
        String actualResponseBody = mvcResult.getResponse().getContentAsString();
        assertThat(objectMapper.writeValueAsString(expectedResponseBody), equalTo(actualResponseBody));

    }

    @Test
   public void whenNullValue_thenReturns400AndErrorResult() throws Exception {
        Patient patient = new Patient(null, "Maina","Kariuki", 12345678, new Date(),
                22, "Male","Kenya","Kiambu", 623413423, "776-00290",
                "maina@gmail.com", new Date(), "KOOQ");

        MvcResult mvcResult = mockMvc.perform(post("/patient/addpatient")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(patient)))
                .andExpect(status().isBadRequest())
                .andReturn();


    }

}