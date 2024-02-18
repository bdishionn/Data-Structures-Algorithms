package sortcomparison;

import java.util.*;

public class BasicSorter implements Sorter {

	@Override
	public void insertionSort(String[] data, int fi, int n) {
		for (int i = fi; i < data.length; i++) {
			int index = i;
			var datai = data[i];

			for (int j = i; j < data.length; j++) {
				if (datai.compareTo(data[j]) > 0) {
					datai = data[j];
					index = j;
				}
			}
			data[index] = data[i];
			data[i] = datai;
		}

	}


	@Override
	public void quickSort(String[] data, int fi, int n) {
		// if (n <= 15) {
		// insertionSort(data, fi, n);

		if (n > 1) { // if num of items is greater than 1
			int piv = partition(data, fi, n); // partioning data

			int l = piv - fi; // left partition of pivot
			int r = n - (l + 1); // right partition of pivot

			quickSort(data, fi, l); // ascending order
			quickSort(data, piv + 1, r);
		}
	}

	// }


	@Override
	public int partition(String[] data, int fi, int n) {

		var datafi = data[fi];
		data[fi] = data[fi + n / 2];
		data[fi + n / 2] = datafi; // mid-way point of data

		int tooBig = fi; // too Big index
		int tooSmall = fi + n - 1; // too Small index
		var piv = data[fi]; // first element is pivot

		while (tooBig < tooSmall) { // while tbi < tsi
			while ((tooBig < tooSmall) && (data[tooBig].compareTo(piv) <= 0)) // all vals are less than i of piv
				tooBig++;

			while ((tooSmall > fi) && (data[tooSmall].compareTo(piv) > 0)) // all vals are greater than i of piv
				tooSmall--;

			if (tooBig < tooSmall) { // if tbi is less tsi
				datafi = data[tooSmall]; // data of first i = data of tsi, piv is now at end
				data[tooSmall] = data[tooBig]; // data of tsi swaps data with tbi
				data[tooBig] = datafi; // data of tbi swaps with tsi
			}
		}
		if (piv.compareTo(data[tooSmall]) >= 0) { // if piv data is >= tsi data
			datafi = data[tooSmall]; // swap data of fi and tsi
			data[tooSmall] = data[fi]; // same swap
			data[fi] = datafi; // redeclaring variable
			return tooSmall; // return tsi
		}
		return fi; // otherwise return fi
	}


	@Override
	public void mergeSort(String[] data, int fi, int n) {
		// if (n <= 15) {
		// insertionSort(data, fi, n);
		if (n > 1) {
			int halfway = fi + n / 2;
			int left = halfway - fi; // size of left
			int right = n - left; // size of right

			mergeSort(data, fi, left); // merging left
			mergeSort(data, halfway, right); // merging right
			if (data[halfway - 1].compareTo(data[halfway]) > 0)
				merge(data, fi, left, right); // merging if halfs are not even
		}

	}
	// }


	@Override
	public void merge(String[] data, int fi, int nl, int nr) {
		var arY = new ArrayList<>(); // new array list
		int leftI = 0, rightI = 0; // declaring left and right index

		while (leftI != nl && rightI != nr) { // while still copying
			if (data[fi + leftI].compareTo(data[fi + nl + rightI]) >= 0) { // right is empty
				arY.add(data[fi + nl + rightI++]); // copy head of left to array
			} else {
				arY.add(data[fi + leftI++]); // otherwise copy head of right to array
			}
		}

		for (int i = leftI; i < nl; i++) {
			arY.add(data[fi + i]); // copies left index elements from fi to left i
		}
		for (int i = rightI; i < nr; i++) {
			arY.add(data[fi + nl + i]); // copies right index elements from fi to right i
		}
		for (int i = 0; i < (nl + nr); i++)
			data[fi + i] = (String) arY.get(i); // empty

	}


	@Override
	public void heapSort(String[] data) {
		// TODO Auto-generated method stub

	}


	@Override
	public void heapify(String[] data) {
		// TODO Auto-generated method stub

	}

}
