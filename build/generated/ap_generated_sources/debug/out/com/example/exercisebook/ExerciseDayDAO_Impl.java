package com.example.exercisebook;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ExerciseDayDAO_Impl implements ExerciseDayDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ExerciseDay> __insertionAdapterOfExerciseDay;

  private final EntityDeletionOrUpdateAdapter<ExerciseDay> __deletionAdapterOfExerciseDay;

  private final EntityDeletionOrUpdateAdapter<ExerciseDay> __updateAdapterOfExerciseDay;

  public ExerciseDayDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfExerciseDay = new EntityInsertionAdapter<ExerciseDay>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ExerciseDay` (`Id`,`userId`,`date`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ExerciseDay value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUserId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getUserId());
        }
        final Long _tmp;
        _tmp = RoomConverters.fromDate(value.getDate());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp);
        }
      }
    };
    this.__deletionAdapterOfExerciseDay = new EntityDeletionOrUpdateAdapter<ExerciseDay>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ExerciseDay` WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ExerciseDay value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfExerciseDay = new EntityDeletionOrUpdateAdapter<ExerciseDay>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `ExerciseDay` SET `Id` = ?,`userId` = ?,`date` = ? WHERE `Id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ExerciseDay value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getUserId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getUserId());
        }
        final Long _tmp;
        _tmp = RoomConverters.fromDate(value.getDate());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp);
        }
        if (value.getId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getId());
        }
      }
    };
  }

  @Override
  public void insert(final ExerciseDay day) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfExerciseDay.insert(day);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final ExerciseDay day) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfExerciseDay.handle(day);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ExerciseDay day) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfExerciseDay.handle(day);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<ExerciseDay>> getAllDaysByUserId(final Integer userId) {
    final String _sql = "SELECT Id, userId, date FROM ExerciseDay WHERE userId=? ORDER BY date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, userId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"ExerciseDay"}, false, new Callable<List<ExerciseDay>>() {
      @Override
      public List<ExerciseDay> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "Id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final List<ExerciseDay> _result = new ArrayList<ExerciseDay>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ExerciseDay _item;
            final Integer _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getInt(_cursorIndexOfUserId);
            }
            final Date _tmpDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = RoomConverters.toDate(_tmp);
            _item = new ExerciseDay(_tmpUserId,_tmpDate);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
