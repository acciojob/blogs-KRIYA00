package com.driver.services;

import com.driver.exceptions.BlogNotFoundException;
import com.driver.exceptions.ImageNotFoundException;
import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Image image=new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);
        Optional<Blog>optionalBlog=blogRepository2.findById(blogId);
        if(optionalBlog.isEmpty())
            throw new BlogNotFoundException("Blog with given blogId not found!!");
        else {
            Blog blog=optionalBlog.get();
            imageRepository2.save(image);
            blog.getImageList().add(image);
            blogRepository2.save(blog);
            return image;
        }
    }

    public void deleteImage(Integer id){
        blogRepository2.deleteById(id);

    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
            Optional<Image> imageOptional=imageRepository2.findById(id);
            if(imageOptional.isEmpty())
                throw new ImageNotFoundException("Image with given id not found!!");
              else {
                  Image image=imageOptional.get();
                String imagedimensions = image.getDimensions();
                int[]givendimensionsarray=new int[2];
                givendimensionsarray=helper(imagedimensions);
                int[]screendimensionarray=new int[2];
                screendimensionarray=helper(screenDimensions);
                int count=(screendimensionarray[0]*screendimensionarray[1])/(givendimensionsarray[0]*givendimensionsarray[1]);
              return count;
            }

    }
    public int[] helper(String dimensions)
    {
        int val=0;
        int[]arr=new int[2];
        for(int i=0;i<dimensions.length();i++)
        {
            char ch=dimensions.charAt(i);
            if(!Character.isDigit(ch))
            {
                 arr[0]=val;
                 val=0;
            }
            else {
              val=val*10+(ch-'a');
            }

        }
        arr[1]=val;
        return arr;
    }
}
