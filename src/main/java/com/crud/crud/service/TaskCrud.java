
package com.codility.tasks.hibernate.solution;

import org.springframework.data.jpa.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.logging.Logger;
import java.util.Objects;
import java.util.Optional;

@Table
@Entity
class Task {
    @Id
    @Column(nullable=false)
    private Long id;
    @Column(nullable=false)
    private String description ;
    @Column
    private Long priority ;

    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id=id;
    }
    
    public Long getPriority()
    {
        return priority;
    }
    public void setPriority(Long priority)
    {
        this.priority=priority;
    }

    public String getDescription ()
    {
        return description ;
    }
    public void setDescription (String description)
    {
        this.description =description ;
    }

}

class TaskResponse{

    private String description;
    private Long priority;
    public Long getPriority()
    {
        return priority;
    }
    public void setPriority(Long priority)
    {
        this.priority=priority;
    }

    public String getDescription ()
    {
        return description ;
    }
    public void setDescription (String description)
    {
        this.description =description ;
    }

}

class ExceptionResponse
{
 private String message;
 private int  status;

    public ExceptionResponse( String message,int status)
    {
        super();
        this.message=message;
        this.status=status;
        
    }

     public String getMessage ()
    {
        return message ;
    }
    public void setMessage ()
    {
        this.message =message ;
    }

     public int getStatus ()
    {
        return status ;
    }
    public void setStatus ()
    {
        this.status =status ;
    }

}

@RestController
class TaskController {
  private static Logger log = Logger.getLogger("Solution");
  // log.info("You can use 'log' for debug messages");

@Autowired
TaskRepository taskRepository  ;

@PutMapping("/tasks/{id}")
private ResponseEntity<Object> updateDescription(@RequestBody Task task,@PathVariable Long id)
{
    ExceptionResponse exceptionResponse =null;
    

    task.setId(id);

    if(Objects.isNull(task.getDescription()) || task.getDescription().isEmpty())
    {
        exceptionResponse=new ExceptionResponse("Task description is required" ,400);//HttpStatus.BAD_REQUEST);
        return new ResponseEntity<Object>(exceptionResponse,new HttpHeaders(),HttpStatus.BAD_REQUEST);
    }

    Optional<Task> respTask= taskRepository.findById(id);

    if(!respTask.isPresent())
    {
         exceptionResponse= new ExceptionResponse("Cannot find task with given id" ,404);//HttpStatus.NOT_FOUND);//HttpStatus.NOT_FOUND);
        return new ResponseEntity<Object>(exceptionResponse,new HttpHeaders(),HttpStatus.NOT_FOUND);

    }

  Task saveTask= taskRepository.save(task);

  TaskResponse taskResponse = new TaskResponse ();
   taskResponse.setDescription(saveTask.getDescription());
   taskResponse.setPriority(saveTask.getPriority());

  return new ResponseEntity<Object>(taskResponse,new HttpHeaders(),HttpStatus.OK);

}

}

interface TaskRepository extends JpaRepository<Task, Long> {

}



Regards,
Dhiraj Surve 
 

