package com.qwert2603.retrobase_example;

import com.qwert2603.retrobase.generated.SpendDBImpl;
import com.qwert2603.retrobase.rx.generated.SpendDBRx;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class DataManager {

    private SpendDB mSpendDB = new SpendDBImpl();
    private SpendDBRx mSpendDBRx = new SpendDBRx(mSpendDB);

    public Single<List<DataBaseRecord>> getAllRecordsFromDataBase() {
        return mSpendDBRx.getAllRecordsOrdered()
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Id> insertRecord(DataBaseRecord dataBaseRecord) {
        return mSpendDBRx.insertRecord(dataBaseRecord.getKind(), dataBaseRecord.getValue(), dataBaseRecord.getDate())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Completable removeRecord(int id) {
        return mSpendDBRx.deleteRecord(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
