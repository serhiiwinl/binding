package com.partypoker.poker.others;

/**
 * Created by sliubetskyi on 3/24/16.
 */
public interface State<T> {
    public T getActivity();
    public String getActivityName();

}
