package com.chrzanop.coding.algoexpert.binarysearchtrees;

public class BST {

    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
        this.value = value;
    }

    // Average: O(log(n)) time | O(1) space
    // Worst: O(n) time | O(1) space - if tree not balanced
    public BST insert(int value) {
        BST currentNode = this;
        while (true) {
            if (value < currentNode.value) {
                if (currentNode.left == null) {
                    BST node = new BST(value);
                    currentNode.left = node;
                    break;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null) {
                    BST node = new BST(value);
                    currentNode.right = node;
                    break;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
        return this;
    }

    // Average: O(log(n)) time | O(1) space
    // Worst: O(n) time | O(1) space - if tree not balanced
    public boolean contains(int value) {
        BST currentNode = this;
        while (currentNode != null) {
            if (value < currentNode.value) {
                currentNode = currentNode.left;
            } else if (value > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                return true;
            }
        }

        return false;
    }

    // Average: O(log(n)) time | O(log(n)) space
    // Worst: O(n) time | O(n) space - if tree not balanced
    public boolean containsR(int value) {
        if (value < this.value) {
            if (left == null) {
                return false;
            } else {
                left.containsR(left.value);
            }
        } else if (value > this.value) {
            if (right == null) {
                return false;
            } else {
                right.containsR(right.value);
            }
        }
        return true;
    }


    public BST remove(int value) {
        remove(value, null);
        return this;
    }


    // Average: O(log(n)) time | O(1) space
    // Worst: O(n) time | O(1) space - if tree not balanced
    public void remove(int value, BST parentNode) {
        BST currentNode = this;
        while (currentNode != null) {
            if (value < currentNode.value) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else if (value > currentNode.value) {
                parentNode = currentNode;
                currentNode = currentNode.right;
            } else {  // explicit check (value == currentNode.value) , else is enough
                if (currentNode.left != null && currentNode.right != null) {
                    currentNode.value = currentNode.right.getMinValue();
                    currentNode.right.remove(currentNode.value, currentNode);
                } else if (parentNode == null) {
                    if (currentNode.left != null) {
                        currentNode.value = currentNode.left.value;
                        currentNode.right = currentNode.left.right;
                        currentNode.left = currentNode.left.left;
                        currentNode = null;
                    } else if (currentNode.right != null) {
                        currentNode.value = currentNode.right.value;
                        currentNode.left = currentNode.right.left;
                        currentNode.right = currentNode.right.right;
                        currentNode = null;
                    } else {
                        // this is a single-node tree; do nothing
                        currentNode = null;
                    }
                } else if (parentNode.left == currentNode) {
                    parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
                    currentNode = null;
                } else if (currentNode.right != null) {
                    parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
                    currentNode = null;
                }

            }
        }
    }

    // recursively
    // Average: O(log(n)) time | O(log(n)) space
    // Worst: O(n) time | O(n) space - if tree not balanced
    public BST removeR(int value) {
        removeR(value, null);
        return this;
    }

    public void removeR(int value, BST parent) {
        if (value < this.value) {
            if (left != null) {
                left.remove(value, this);
            }
        } else if (value > this.value) {
            if (right != null) {
                right.remove(value, this);
            }
        } else {
            if (left != null && right != null) {
                this.value = right.getMinValue();
                right.remove(this.value, this);
            } else if (parent == null) {
                if (left != null) {
                    this.value = left.value;
                    right = left.right;
                    left = left.left;
                } else if (right != null) {
                    this.value = right.value;
                    left = right.left;
                    right = right.right;
                } else {
                    // single-node do nothing
                }
            } else if (parent.left == this) {
                parent.left = left != null ? left : right;
            } else if (parent.right == this) {
                parent.right = left != null ? left : right;
            }
        }
    }


    public int getMinValue() {
        if (left == null) {
            return value;
        } else {
            return left.getMinValue();
        }
    }

}

