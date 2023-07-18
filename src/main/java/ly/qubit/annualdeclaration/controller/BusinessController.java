package ly.qubit.annualdeclaration.controller;

import ly.qubit.annualdeclaration.dto.DeclarationRequest;
import ly.qubit.annualdeclaration.dto.ReviewRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController("https://api:8080")
public class BusinessController {

    /*
    * Submit Annual Declaration
       Endpoint: POST /api/declarations
        Controller Method:
    * */
    @PostMapping("/declarations")
    public ResponseEntity<?> submitDeclaration(@RequestBody DeclarationRequest request) {
        // Implementation logic for submitting an annual declaration using JPA and database operations
        // Return appropriate response entity based on the result
        return null;
    }
    @PutMapping(value = "/api/declarations", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> submitDeclaration(@RequestPart("declaration") DeclarationRequest requestDTO,
                                               @RequestPart("files") List<MultipartFile> pdfFiles) {
        // Extract data from the DeclarationRequestDTO and perform necessary processing
        // e.g., extract the user ID from the jwt token
        // then use the user ID to retrieve the user from the database
        // then match the user with the declaration
        // then send it to the service layer
        //todo make new entity for declaration member  and add it to the declaration as a set of members




        // Access the uploaded PDF files
        for (MultipartFile pdfFile : pdfFiles) {
            if (pdfFile != null && pdfFile.getContentType().equals("application/pdf")) {
                // Process each PDF file, e.g., save it to a storage location
            } else {
                // Handle invalid or missing PDF file
            }
        }

        // Implement the logic for creating and persisting the declaration using the extracted data and PDF files

        // Return appropriate response entity based on the result
        return null;
    }


    /*
    * Review Annual Declaration by admin
      Endpoint: PUT /api/declarations/{id}/review
    * */
    @PutMapping("/api/declarations/{id}/review")
    public ResponseEntity<?> reviewDeclaration(@PathVariable("id") Long declarationId, @RequestBody ReviewRequest request) {
        // Implementation logic for reviewing and updating the status of an annual declaration using JPA and database operations
        // use last modfiyed by to check if user update the content of the declaration
        //if the status is rejected and the user update the content of the declaration then it need to be reviewed again
        //if the state is approved then the user can't update the content of the declaration
        //if the status is pending then the user can update the content of the declaration
        // if the status is pending and the user update the content of the declaration then it need to be reviewed again
        //when the user update the content of the declaration the status will be pending
        //when the user submit the declaration the status will be pending

         // Return appropriate response entity based on the result
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    /*
       * the user ask for request Review Annual Declaration
         Endpoint: PUT /api/declarations/{id}/requestReview
       * */
    @PutMapping("/api/declarations/{id}/requestReview")
   public  ResponseEntity<?> requestReview(){
        // Implementation logic for requesting review of an annual declaration using JPA and database operations
        //change the status to pending

        // Return appropriate response entity based on the result
        return null;
    }


    /*
    *  Generate Reports
       Endpoint: GET /api/reports
    * */
    @GetMapping("/api/reports")
    public ResponseEntity<?> generateReports() {
        // Implementation logic for generating reports using JPA and database operations
        // Return appropriate response entity with the generated report data
        return null;
    }




}
