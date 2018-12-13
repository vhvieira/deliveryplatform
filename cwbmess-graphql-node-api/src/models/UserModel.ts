import * as Sequelize from "sequelize";
import { BaseModelInterface } from "../interfaces/BaseModelInterface";
import { genSaltSync,  hashSync, compareSync} from 'bcryptjs';
import { ModelsInterface } from "../interfaces/ModelsInterface";

export interface UserAttributes {
    id?: number;
    name?: string;
    email?: string;
    password?: string;
    photo?: string;
    createdAt?: string;
    updateAt?: string;
}

export interface UserIntance extends Sequelize.Instance<UserAttributes>, UserAttributes {
    isPassword(encodedPassword: string, password: string): boolean;
}

export interface UserModel extends BaseModelInterface, Sequelize.Model<UserIntance, UserAttributes> {}

export default (sequelize: Sequelize.Sequelize, DataTypes: Sequelize.DataTypes): UserModel => {
    const User: UserModel = sequelize.define('User', {
        id: {
            type: DataTypes.INTEGER,
            allowNull: false,
            primaryKey: true,
            autoIncrement: true
        },
        name: {
            type: DataTypes.STRING(128),
            allowNull: false
        },
        email: {
            type: DataTypes.STRING(128),
            allowNull: false,
            validate: {
                notEmpty: true
            }
        },
        password: {
            type: DataTypes.STRING(128),
            allowNull: false,
            validate: {
                notEmpty: true
            }
        },
        photo: {
            type: DataTypes.BLOB({
                length: 'long'
            }),
            allowNull: true
        }
    }, {
        tableName: 'users',
        hooks: {
            beforeCreate: (user: UserIntance, options: Sequelize.CreateOptions): void => {
                const salt = genSaltSync();
                user.password = hashSync(user.password, salt);
            }
        }
    });

    User.associate = (models: ModelsInterface): void => {};

    User.prototype.isPassword = (encodedPassword: string, password: string): boolean => {
        return compareSync(password, encodedPassword);
    }

    return User;
}