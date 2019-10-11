
package com.mahmoudsalah.loginapp;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

public class film
{
  private String stars;
  private java.util.Date created;
  private java.util.Date updated;
  private String plot;
  private String objectId;
  private String ownerId;
  private String title;
  public String getStars()
  {
    return stars;
  }

  public void setStars( String stars )
  {
    this.stars = stars;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getPlot()
  {
    return plot;
  }

  public void setPlot( String plot )
  {
    this.plot = plot;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle( String title )
  {
    this.title = title;
  }

                                                    
  public film save()
  {
    return Backendless.Data.of( film.class ).save( this );
  }

  public void saveAsync( AsyncCallback<film> callback )
  {
    Backendless.Data.of( film.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( film.class ).remove( this );
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( film.class ).remove( this, callback );
  }

  public static film findById( String id )
  {
    return Backendless.Data.of( film.class ).findById( id );
  }

  public static void findByIdAsync( String id, AsyncCallback<film> callback )
  {
    Backendless.Data.of( film.class ).findById( id, callback );
  }

  public static film findFirst()
  {
    return Backendless.Data.of( film.class ).findFirst();
  }

  public static void findFirstAsync( AsyncCallback<film> callback )
  {
    Backendless.Data.of( film.class ).findFirst( callback );
  }

  public static film findLast()
  {
    return Backendless.Data.of( film.class ).findLast();
  }

  public static void findLastAsync( AsyncCallback<film> callback )
  {
    Backendless.Data.of( film.class ).findLast( callback );
  }

  public static List<film> find( DataQueryBuilder queryBuilder )
  {
    return Backendless.Data.of( film.class ).find( queryBuilder );
  }

  public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<film>> callback )
  {
    Backendless.Data.of( film.class ).find( queryBuilder, callback );
  }
}