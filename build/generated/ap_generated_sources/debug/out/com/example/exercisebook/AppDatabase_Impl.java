package com.example.exercisebook;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile UserDAO _userDAO;

  private volatile ExerciseDayDAO _exerciseDayDAO;

  private volatile MeasurementDayDAO _measurementDayDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `User` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `firstName` TEXT, `lastName` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ExerciseDay` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `userId` INTEGER, `date` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MeasurementDay` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `userId` INTEGER, `date` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Exercise` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `dayId` INTEGER, `excerciseName` TEXT, `numberOfSets` INTEGER, `weight` REAL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Measurement` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `userId` INTEGER, `height` REAL, `weight` REAL, `shoulderWidth` REAL, `chestWidth` REAL, `waistWidth` REAL, `hipsWidth` REAL, `thighsWidth` REAL, `upperArmWidth` REAL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5705e131f1b723f1260b9ab84af0157e')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `User`");
        _db.execSQL("DROP TABLE IF EXISTS `ExerciseDay`");
        _db.execSQL("DROP TABLE IF EXISTS `MeasurementDay`");
        _db.execSQL("DROP TABLE IF EXISTS `Exercise`");
        _db.execSQL("DROP TABLE IF EXISTS `Measurement`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUser = new HashMap<String, TableInfo.Column>(3);
        _columnsUser.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("firstName", new TableInfo.Column("firstName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("lastName", new TableInfo.Column("lastName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUser = new TableInfo("User", _columnsUser, _foreignKeysUser, _indicesUser);
        final TableInfo _existingUser = TableInfo.read(_db, "User");
        if (! _infoUser.equals(_existingUser)) {
          return new RoomOpenHelper.ValidationResult(false, "User(com.example.exercisebook.User).\n"
                  + " Expected:\n" + _infoUser + "\n"
                  + " Found:\n" + _existingUser);
        }
        final HashMap<String, TableInfo.Column> _columnsExerciseDay = new HashMap<String, TableInfo.Column>(3);
        _columnsExerciseDay.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExerciseDay.put("userId", new TableInfo.Column("userId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExerciseDay.put("date", new TableInfo.Column("date", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysExerciseDay = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesExerciseDay = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoExerciseDay = new TableInfo("ExerciseDay", _columnsExerciseDay, _foreignKeysExerciseDay, _indicesExerciseDay);
        final TableInfo _existingExerciseDay = TableInfo.read(_db, "ExerciseDay");
        if (! _infoExerciseDay.equals(_existingExerciseDay)) {
          return new RoomOpenHelper.ValidationResult(false, "ExerciseDay(com.example.exercisebook.ExerciseDay).\n"
                  + " Expected:\n" + _infoExerciseDay + "\n"
                  + " Found:\n" + _existingExerciseDay);
        }
        final HashMap<String, TableInfo.Column> _columnsMeasurementDay = new HashMap<String, TableInfo.Column>(3);
        _columnsMeasurementDay.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurementDay.put("userId", new TableInfo.Column("userId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurementDay.put("date", new TableInfo.Column("date", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMeasurementDay = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMeasurementDay = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMeasurementDay = new TableInfo("MeasurementDay", _columnsMeasurementDay, _foreignKeysMeasurementDay, _indicesMeasurementDay);
        final TableInfo _existingMeasurementDay = TableInfo.read(_db, "MeasurementDay");
        if (! _infoMeasurementDay.equals(_existingMeasurementDay)) {
          return new RoomOpenHelper.ValidationResult(false, "MeasurementDay(com.example.exercisebook.MeasurementDay).\n"
                  + " Expected:\n" + _infoMeasurementDay + "\n"
                  + " Found:\n" + _existingMeasurementDay);
        }
        final HashMap<String, TableInfo.Column> _columnsExercise = new HashMap<String, TableInfo.Column>(5);
        _columnsExercise.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExercise.put("dayId", new TableInfo.Column("dayId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExercise.put("excerciseName", new TableInfo.Column("excerciseName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExercise.put("numberOfSets", new TableInfo.Column("numberOfSets", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExercise.put("weight", new TableInfo.Column("weight", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysExercise = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesExercise = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoExercise = new TableInfo("Exercise", _columnsExercise, _foreignKeysExercise, _indicesExercise);
        final TableInfo _existingExercise = TableInfo.read(_db, "Exercise");
        if (! _infoExercise.equals(_existingExercise)) {
          return new RoomOpenHelper.ValidationResult(false, "Exercise(com.example.exercisebook.Exercise).\n"
                  + " Expected:\n" + _infoExercise + "\n"
                  + " Found:\n" + _existingExercise);
        }
        final HashMap<String, TableInfo.Column> _columnsMeasurement = new HashMap<String, TableInfo.Column>(10);
        _columnsMeasurement.put("Id", new TableInfo.Column("Id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("userId", new TableInfo.Column("userId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("height", new TableInfo.Column("height", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("weight", new TableInfo.Column("weight", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("shoulderWidth", new TableInfo.Column("shoulderWidth", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("chestWidth", new TableInfo.Column("chestWidth", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("waistWidth", new TableInfo.Column("waistWidth", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("hipsWidth", new TableInfo.Column("hipsWidth", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("thighsWidth", new TableInfo.Column("thighsWidth", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("upperArmWidth", new TableInfo.Column("upperArmWidth", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMeasurement = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMeasurement = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMeasurement = new TableInfo("Measurement", _columnsMeasurement, _foreignKeysMeasurement, _indicesMeasurement);
        final TableInfo _existingMeasurement = TableInfo.read(_db, "Measurement");
        if (! _infoMeasurement.equals(_existingMeasurement)) {
          return new RoomOpenHelper.ValidationResult(false, "Measurement(com.example.exercisebook.Measurement).\n"
                  + " Expected:\n" + _infoMeasurement + "\n"
                  + " Found:\n" + _existingMeasurement);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "5705e131f1b723f1260b9ab84af0157e", "63c21e1df87187ddcdcc75df6f3214f7");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "User","ExerciseDay","MeasurementDay","Exercise","Measurement");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `User`");
      _db.execSQL("DELETE FROM `ExerciseDay`");
      _db.execSQL("DELETE FROM `MeasurementDay`");
      _db.execSQL("DELETE FROM `Exercise`");
      _db.execSQL("DELETE FROM `Measurement`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public UserDAO userDao() {
    if (_userDAO != null) {
      return _userDAO;
    } else {
      synchronized(this) {
        if(_userDAO == null) {
          _userDAO = new UserDAO_Impl(this);
        }
        return _userDAO;
      }
    }
  }

  @Override
  public ExerciseDayDAO exerciseDayDao() {
    if (_exerciseDayDAO != null) {
      return _exerciseDayDAO;
    } else {
      synchronized(this) {
        if(_exerciseDayDAO == null) {
          _exerciseDayDAO = new ExerciseDayDAO_Impl(this);
        }
        return _exerciseDayDAO;
      }
    }
  }

  @Override
  public MeasurementDayDAO measurementDayDao() {
    if (_measurementDayDAO != null) {
      return _measurementDayDAO;
    } else {
      synchronized(this) {
        if(_measurementDayDAO == null) {
          _measurementDayDAO = new MeasurementDayDAO_Impl(this);
        }
        return _measurementDayDAO;
      }
    }
  }
}
