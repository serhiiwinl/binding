package com.partypoker.poker.trackers;

import com.partypoker.poker.tracking.*;

public interface ICommonAppUsageTrackerInterface extends ILoginEvents, IPokerGamePlay, ILogoutEvents, INavigationEvents,
        IUserActions, IBaseApplicationActions, IConfigLoaded {

}