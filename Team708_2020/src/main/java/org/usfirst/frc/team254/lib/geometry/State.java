package org.usfirst.frc.team254.lib.geometry;

import org.usfirst.frc.team1323.lib.util.Interpolable;
import org.usfirst.frc.team254.lib.util.CSVWritable;

public interface State<S> extends Interpolable<S>, CSVWritable {
    double distance(final S other);

    boolean equals(final Object other);

    String toString();

    String toCSV();
}
