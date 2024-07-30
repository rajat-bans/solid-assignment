let id = 0;
function createProduct(productName, price) {
    let promise = new Promise((resolve, reject) => {
        try {
            let product = { id: id, name: productName, price: price };
            id = id + 1;
            resolve(product);
        }
        catch {
            reject("Error occured");
        }
    })
    return promise;
}

function Cart() {
    this.cartItems = [];
    this.printList = function () {
        this.cartItems.forEach((cartItem) => {
            console.log(cartItem);
        })
    }
    this.addMany = async function (productsDetails) {
        let createdProductsDetailsPromise = [];
        productsDetails.forEach(productDetails => {
            let createdProductDetailsPromise = createProduct(...productDetails);
            createdProductDetailsPromise.then((createdProductDetails) => {
                this.cartItems.push(createdProductDetails);
            })
            createdProductsDetailsPromise.push(createdProductDetailsPromise);
        });
        return await Promise.all(createdProductsDetailsPromise);
    }
}

async function main() {
    const cart = new Cart();
    await cart.addMany([
        ["Samsung A30", 30],
        ["boat earphone", 45]
    ]);
    await cart.addMany([
        ["Nord 3", 20]
    ])
    cart.printList();
}

main();